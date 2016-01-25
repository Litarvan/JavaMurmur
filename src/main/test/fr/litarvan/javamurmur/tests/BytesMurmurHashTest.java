package fr.litarvan.javamurmur.tests;

import fr.litarvan.javamurmur.BytesMurmurHasher;
import fr.litarvan.javamurmur.MurmurHash;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BytesMurmurHashTest
{
    public static byte[] TO_HASH = new byte[]{5, 2, 55, 78};

    public static int EXCEPTED_INT = 1508311339;
    public static String EXCEPTED_STRING = "1cue09b";

    public static int SEED = 488657;

    public static int EXCEPTED_INT_WITH_SEED = -294915259;
    public static String EXCEPTED_STRING_WITH_SEED = "-8p835r";

    private BytesMurmurHasher hasher;

    @Before
    public void setUp()
    {
        hasher = new BytesMurmurHasher();
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
