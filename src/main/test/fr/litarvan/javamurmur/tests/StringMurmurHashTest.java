package fr.litarvan.javamurmur.tests;

import fr.litarvan.javamurmur.BytesMurmurHasher;
import fr.litarvan.javamurmur.MurmurHash;
import fr.litarvan.javamurmur.StringMurmurHasher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class StringMurmurHashTest
{
    public static String TO_HASH = "Hello ! I am a very cool string";

    public static int EXCEPTED_INT = -1987860410;
    public static String EXCEPTED_STRING = "-1r7oltq";

    public static int SEED = 552546;

    public static int EXCEPTED_INT_WITH_SEED = 1304584995;
    public static String EXCEPTED_STRING_WITH_SEED = "16s4op3";

    private StringMurmurHasher hasher;

    @Before
    public void setUp()
    {
        hasher = new StringMurmurHasher();
    }

    @After
    public void tearDown()
    {
        hasher = null;
    }

    @Test
    public void byteArrayHashTest()
    {
        MurmurHash hash = hasher.hash(TO_HASH);

        assertEquals(EXCEPTED_INT, hash.toInt());
        assertEquals(EXCEPTED_STRING, hash.toString());
    }

    @Test
    public void seededByteArrayHashTest()
    {
        MurmurHash hash = hasher.hash(TO_HASH, SEED);

        assertEquals(EXCEPTED_INT_WITH_SEED, hash.toInt());
        assertEquals(EXCEPTED_STRING_WITH_SEED, hash.toString());
    }
}
