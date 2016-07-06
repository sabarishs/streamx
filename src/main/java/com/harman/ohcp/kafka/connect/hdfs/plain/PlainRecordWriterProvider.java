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

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.Path;
import org.apache.kafka.connect.sink.SinkRecord;

import io.confluent.connect.avro.AvroData;
import io.confluent.connect.hdfs.RecordWriter;
import io.confluent.connect.hdfs.RecordWriterProvider;

public class PlainRecordWriterProvider implements RecordWriterProvider {

  private final static String EXTENSION = ".txt";

  @Override
  public String getExtension() {
    return EXTENSION;
  }

  @Override
  public RecordWriter<SinkRecord> getRecordWriter(
      Configuration conf, final String fileName, SinkRecord record, final AvroData avroData)
      throws IOException {
    Path path = new Path(fileName);
    final FSDataOutputStream out = path.getFileSystem(conf).create(path);
    final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    return new RecordWriter<SinkRecord>() {
      @Override
      public void write(SinkRecord record) throws IOException {
        bw.write(record.value().toString());
        bw.newLine();
      }

      @Override
      public void close() throws IOException {
        bw.close();
      }
    };
  }
}
