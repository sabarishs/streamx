/**
 * Copyright 2015 Confluent Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 **/

package com.harman.ohcp.kafka.connect.hdfs.plain;

import org.apache.hadoop.hive.ql.metadata.Table;
import org.apache.kafka.connect.data.Schema;

import io.confluent.connect.avro.AvroData;
import io.confluent.connect.hdfs.HdfsSinkConnectorConfig;
import io.confluent.connect.hdfs.errors.HiveMetaStoreException;
import io.confluent.connect.hdfs.hive.HiveMetaStore;
import io.confluent.connect.hdfs.hive.HiveUtil;
import io.confluent.connect.hdfs.partitioner.Partitioner;

public class PlainFormatHiveUtil extends HiveUtil {

  public PlainFormatHiveUtil(HdfsSinkConnectorConfig connectorConfig, AvroData avroData, HiveMetaStore hiveMetaStore) {
    super(connectorConfig, avroData, hiveMetaStore);
  }

  @Override
  public void createTable(String database, String tableName, Schema schema, Partitioner partitioner)
      throws HiveMetaStoreException {
  }

  @Override
  public void alterSchema(String database, String tableName, Schema schema) throws HiveMetaStoreException {
  }

  private Table constructAvroTable(String database, String tableName, Schema schema, Partitioner partitioner)
      throws HiveMetaStoreException {
	  return null;
  }
}
