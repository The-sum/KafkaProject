package the.sum.kafka.producer;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

public class MyPartition implements Partitioner {

    @Override
    public int partition(String topic, Object key, byte[] keybytes, Object value, byte[] valuebytes1, Cluster cluster) {
        //获取的数据 hello world
        String msgvalue = value.toString();

        int par;
        if (msgvalue.contains("hello")){
            par = 2;
        }else {
            par = 0;
        }

        return par;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
