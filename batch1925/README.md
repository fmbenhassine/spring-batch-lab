# Result

Run the `DemoApplication` class, it should print:

```
MyChunkListener.beforeChunk
item = one
item = two
MyChunkListener.afterChunk
MyChunkListener.beforeChunk
item = three
item = four
MyChunkListener.afterChunk
```

This means the chunk size of 2 set as job parameter is correctly configured (using late-binding) on the chunk-oriented step in:

```xml
<batch:chunk reader="itemReader" writer="itemWriter" commit-interval="#{jobParameters['chunk.size']}"/>
```
