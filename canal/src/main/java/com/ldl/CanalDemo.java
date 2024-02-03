package com.ldl;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanalDemo {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        //1.获取 canal 连接对象
        CanalConnector canalConnector = CanalConnectors.
                newSingleConnector(new InetSocketAddress("192.168.68.129", 11111), "example", "", "");
        while (true) {
            //2.获取连接
            canalConnector.connect();
            //3.指定要监控的数据库
            canalConnector.subscribe("canal.*");
            //4.获取 Message
            Message message = canalConnector.get(100);
            //一条SQL 对应一个Entry
            List<CanalEntry.Entry> entries = message.getEntries();
            if (entries.size() <= 0) {
                System.out.println("没有数据，休息一会");
                try {
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                for (CanalEntry.Entry entry : entries) {
                    //entry --> Update SQL --->改动2条数据
                    // 获取表名
                    String tableName = entry.getHeader().getTableName();
                    //  Entry 类型
                    CanalEntry.EntryType entryType = entry.getEntryType();
                    //  判断 entryType 是否为 ROWDATA
                    if (CanalEntry.EntryType.ROWDATA.equals(entryType)) {
                        //  序列化数据
                        ByteString storeValue = entry.getStoreValue();
                        //  反序列化
                        CanalEntry.RowChange rowChange = CanalEntry.RowChange.parseFrom(storeValue);
                        // 获取事件类型
                        CanalEntry.EventType eventType = rowChange.getEventType();
                        // 获取具体的数据
                        List<CanalEntry.RowData> rowDatasList = rowChange.getRowDatasList();
                        // 遍历并打印数据
                        for (CanalEntry.RowData rowData : rowDatasList) {
                            List<CanalEntry.Column> beforeColumnsList = rowData.getBeforeColumnsList();
                            Map<String, Object> bMap = new HashMap<>();
                            for (CanalEntry.Column column : beforeColumnsList) {
                                bMap.put(column.getName(), column.getValue());
                            }
                            Map<String, Object> afMap = new HashMap<>();
                            List<CanalEntry.Column> afterColumnsList = rowData.getAfterColumnsList();
                            for (CanalEntry.Column column : afterColumnsList) {
                                afMap.put(column.getName(), column.getValue());
                            }
                            System.out.println("表名:" + tableName + ",操作类型:" + eventType);
                            System.out.println("改前:" + bMap );
                            System.out.println("改后:" + afMap );
                        }
                    }
                }
            }
        }
    }
}
