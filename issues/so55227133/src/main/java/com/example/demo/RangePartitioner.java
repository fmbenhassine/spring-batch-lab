package com.example.demo;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

public class RangePartitioner implements Partitioner {

    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {

        Map<String, ExecutionContext> result = new HashMap<String, ExecutionContext>();

        int range = 1;

        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream("src/main/resources/data.txt"));
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            while ((readChars = is.read(c)) != -1) {
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            if (count != 0) {
                range = (count/gridSize);
            }
        } catch (Exception e){
            try {
                is.close();
            } catch (Exception e1) {
            }
        } 

        int fromId = 1;
        int toId = range;

        for (int i = 1; i <= gridSize; i++) {
            ExecutionContext value = new ExecutionContext();

            System.out.println("\nHilo : " + i);
            System.out.println("Index Inicial : " + fromId);
            System.out.println("Index Final : " + toId + "\n");

            value.putInt("fromId", fromId - 1);
            value.putInt("toId", toId);

            // give each thread a name, thread 1,2,3
            value.putString("name", "Hilo " + i);

            result.put("partition" + i, value);

            fromId = toId + 1;
            toId += range;
            if (i == gridSize - 1) toId = toId + 1;

        }

        return result;
    }

    // quick check if the partitioner is working as expected
    public static void main(String[] args) {
        RangePartitioner rangePartitioner = new RangePartitioner();
        Map<String, ExecutionContext> partitions = rangePartitioner.partition(3);
        for (String s : partitions.keySet()) {
            ExecutionContext executionContext = partitions.get(s);
            System.out.println("partition = " + executionContext);
        }
    }

}
