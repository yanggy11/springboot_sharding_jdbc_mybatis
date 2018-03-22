package com.yanggy.springboot.datasource;

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
        DataSource shardingDataSource = null;
        // 配置真实数据源
        Map<String, DataSource> dataSourceMap = new HashMap<>();

        // 配置第一个数据源
        dataSourceMap.put("dbs_0", this.buildDataSource(shardingProperties.getUrl(), shardingProperties.getDriverClassName(), shardingProperties.getPassword(), shardingProperties.getUsername()));

        dataSourceMap.put("dbs_1", this.buildDataSource(shardingProperties.getUrl2(), shardingProperties.getDriverClassName(), shardingProperties.getPassword(), shardingProperties.getUsername()));

        TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration();
        orderTableRuleConfig.setLogicTable("user");
        orderTableRuleConfig.setActualDataNodes("dbs_${0..1}.user_${0..2}");
        orderTableRuleConfig.setKeyGeneratorColumnName("id");
        orderTableRuleConfig.setKeyGeneratorClass(DefaultKeyGenerator.class.getName());

        // 配置分库策略
        orderTableRuleConfig.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("user_id", "ds_${user_id % 2}"));

        // 配置分表策略
        orderTableRuleConfig.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("id", "user_${user % 3}"));

        // 配置分片规则
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig);
        return ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, new ConcurrentReaderHashMap(), new Properties());
    }

    private DataSource buildDataSource(String url, String driverClassName, String password, String userName) {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        return dataSource;
    }
}
