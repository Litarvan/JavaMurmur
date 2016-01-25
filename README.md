# JavaMurmur

Simple Murmur 3 Java library.
You can create your Hashing entries, current are : File, String or Byte Array.

```java
MurmurHasher hasher = new StringMurmurHasher();
Hash hash = hasher.hash("Hello !");

System.out.println("Base 32 string hash : " + hash.toString());
System.out.println("Raw hash            : " + hash.toInt());
```

You can remplace StringMurmurHasher by BytesMurmurHasher or FileMurmurHasher.