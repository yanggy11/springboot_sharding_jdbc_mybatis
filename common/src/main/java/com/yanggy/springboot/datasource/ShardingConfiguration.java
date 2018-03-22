package com.yanggy.springboot.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import io.shardingjdbc.core.api.ShardingDataSourceFactory;
import io.shardingjdbc.core.api.config.ShardingRuleConfiguration;
import io.shardingjdbc.core.api.config.TableRuleConfiguration;
import io.shardingjdbc.core.api.config.strategy.InlineShardingStrategyConfiguration;
import io.shardingjdbc.core.keygen.DefaultKeyGenerator;
import org.apache.commons.dbcp.BasicDataSource;
import org.codehaus.groovy.runtime.metaclass.ConcurrentReaderHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: yangguiyun
 * @Date: 2018/3/22 10:35
 * @Description:
 */

@Component
public class ShardingConfiguration {

    @Autowired
    private ShardingProperties shardingProperties;
    @Bean
    public DataSource dataSource() throws SQLException {
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        //配置数据库数据源
        dataSourceMap.put("dbs_0", this.buildDataSource(shardingProperties.getUrl(), shardingProperties.getDriverClassName(), shardingProperties.getPassword(), shardingProperties.getUsername()));
        dataSourceMap.put("dbs_1", this.buildDataSource(shardingProperties.getUrl2(), shardingProperties.getDriverClassName(), shardingProperties.getPassword(), shardingProperties.getUsername()));

        TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration();
        orderTableRuleConfig.setLogicTable("user");
        orderTableRuleConfig.setActualDataNodes("dbs_${0..1}.user_${0..2}");
        orderTableRuleConfig.setKeyGeneratorColumnName("id");
        orderTableRuleConfig.setKeyGeneratorClass(DefaultKeyGenerator.class.getName());
        orderTableRuleConfig.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("user_id", "dbs_${user_id % 2}"));
        orderTableRuleConfig.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("id", "user_${id % 3}"));

        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig);

        return ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, new ConcurrentReaderHashMap(), new Properties());
    }

    /**
     * 创建单个数据源
     * @param url
     * @param driverClassName
     * @param password
     * @param userName
     * @return
     */
    private DataSource buildDataSource(String url, String driverClassName, String password, String userName) {
        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        return dataSource;
    }
}
