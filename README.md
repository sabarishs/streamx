# StreamX with support for plain text data: Kafka Connect for S3

_Forked from the neat [streamx][https://github.com/qubole/streamx] which is in turn a fork of the awesome [kafka-connect-hdfs](https://github.com/confluentinc/kafka-connect-hdfs)_

Look up Streamx [here][https://github.com/qubole/streamx]

This fork adds support for schema-less data. Currently there is no support for Hive, esp because there is no schema ;) Streamx and kafka-connect-hdfs provide support for Avro and Parquet. The reason we need schema less is because for true IoT environments schema is not always available.


### Sample Job
```
{"name":"twitter connector",
"config":{
"name":"twitter connector",
"connector.class":"io.confluent.connect.hdfs.HdfsSinkConnector",
"format.class":"com.harman.kafka.connect.hdfs.s3.PlainTextFormat",
"tasks.max":"1",
"flush.size":"100000",
"hdfs.url":"<S3 location>",
  "wal.class":"com.qubole.streamx.s3.wal.DBWAL",
  "db.connection.url":"jdbc:mysql://localhost:3306/kafka",
  "db.user":"username_required",
  "db.password":"password_required",
"hadoop.conf.dir":"/usr/lib/hadoop2/etc/hadoop/",
"topics":"twitter1p"}}
```
Note the use of format.class to use PlainTextFormat
