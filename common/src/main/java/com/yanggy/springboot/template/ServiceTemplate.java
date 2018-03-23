/*
 * Copyright by mobanker and the original author or authors.
 * 
 * This document only allow internal use ,Any of your behaviors using the file
 * not internal will pay legal responsibility.
 *
 * You may learn more information about mobanker from
 *
 *      http://www.mobanker.com/
 *
 */
package com.yanggy.springboot.template;


import java.util.UUID;

/**
 * 调用模板方法，模仿spring jdbcTemplate实现
 * 
 * @author chenjian
 * @since 2016年12月20日 上午10:20:38
 */
public final class ServiceTemplate {

    private ServiceTemplate() {
    }

    /**
     * 执行模板方法，业务逻辑在invoke方法中实现，请求参数为空
     *
     * @author chenjian
     * @since 2016年12月20日 上午11:01:30
     * @param name
     * @param action
     * @return
     * @see
     */
    public static <T> ResponseEntityDto<T> invoke(final String name, Callback<T> action) {
        return invoke(name, Maps.newHashMap(), action);
    }

    /**
     * 执行Controller模板方法，业务逻辑在doExecute方法中实现
     *
     * @author chenjian
     * @since 2016年12月20日 上午11:01:27
     * @param name
     * @param obj
     * @param action
     * @return
     * @see
     */
    public static <T> ResponseEntityDto<T> invoke(final String name, final Object obj, Callback<T> action) {
        ResponseEntityDto<T> res = new ResponseEntityDto<T>();
        String logRandom = UUID.randomUUID().toString().replace("-", "");
        DevLog.info("[{} Request {}] {}", name, logRandom, JSONObject.toJSONString(obj, SerializerFeature.WriteDateUseDateFormat));
        try {
            action.doExecute(res);
            res.setStatus(ExceptionConstants.OK);
            res.setError(ExceptionConstants.SERVER_SUCCESS);
            res.setMsg(ExceptionConstants.SERVER_SUCCESS_MSG);
        } catch (ValidateException e) {
            res.setError(e.getErrorCode());
            res.setMsg(e.getErrorMsg());
            res.setStatus(ExceptionConstants.OK);
            DevLog.warn("调用{}发生校验异常:{}", name, e.getErrorMsg());
        } catch (ServiceException e) {
            res.setError(e.getErrorCode());
            res.setMsg(e.getErrorMsg());
            res.setStatus(ExceptionConstants.OK);
            DevLog.warn("调用{}发生业务异常:{}", name, e.getErrorMsg());
        } catch (Exception e) {
            res.setError(ExceptionConstants.SERVER_ERROR);
            res.setMsg(ExceptionConstants.SERVER_ERROR_MSG);
            res.setStatus(ExceptionConstants.FAIL);
            DevLog.error("调用{}发生异常:", name, e);
        } finally {
            DevLog.info("[{} Response {}] {}", name, logRandom, JSONObject.toJSONString(res, SerializerFeature.WriteDateUseDateFormat));
        }
        return res;
    }
}
