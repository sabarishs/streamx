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
 */

package com.harman.ohcp.kafka.connect.hdfs.plain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.Path;
import org.apache.kafka.connect.data.Schema;

import io.confluent.connect.avro.AvroData;
import io.confluent.connect.hdfs.SchemaFileReader;

public class PlainFileReader implements SchemaFileReader {

  private AvroData avroData;

  public PlainFileReader(AvroData avroData) {
    this.avroData = avroData;
  }

  @Override
  public Schema getSchema(Configuration conf, Path path) throws IOException {
    return null;
  }

  @Override
  public Collection<Object> readData(Configuration conf, Path path) throws IOException {
	final FSDataInputStream in = path.getFileSystem(conf).open(path);
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    String record;
    List<Object> ol = new ArrayList<Object>();
    while ((record = br.readLine()) != null) {
      ol.add(record);
    }
    br.close();
    return ol;
  }
}
