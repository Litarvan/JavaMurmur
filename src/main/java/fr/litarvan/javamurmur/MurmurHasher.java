/*
 * Copyright 2016 Adrien Navratil
 *
 * This file is part of JMurmur.

 * JMurmur is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JMurmur is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JMurmur.  If not, see <http://www.gnu.org/licenses/>.
 */
package fr.litarvan.javamurmur;

public abstract class MurmurHasher<T>
{
    protected abstract byte[] getBytes(T toHash);

    public MurmurHash hash(T toHash)
    {
        return hash(toHash, 0);
    }

    public MurmurHash hash(T toHash, int seed)
    {
        return new MurmurHash(hash(getBytes(toHash), seed));
    }

    private int hash(byte[] key, int seed)
    {
        int klen = key.length;
        int remainder;
        int i, bytes;

        int h1 = seed;
        for (i = 0, bytes = klen - (remainder = klen & 3); i < bytes;)
        {
            int k1 = (((int) key[i] & 0xff)) | (((int) key[++i] & 0xff) << 8) | (((int) key[++i] & 0xff) << 16) | (((int) key[++i] & 0xff) << 24);
            ++i;
            k1 = ((((k1 & 0xffff) * 0xcc9e2d51) + (((((k1 >= 0 ? k1 >> 16 : ((k1 & 0x7fffffff) >> 16) | 0x8000)) * 0xcc9e2d51) & 0xffff) << 16)));
            k1 = k1 << 15 | (k1 >= 0 ? k1 >> 17 : ((k1 & 0x7fffffff) >> 17) | 0x4000);
            k1 = ((((k1 & 0xffff) * 0x1b873593) + (((((k1 >= 0 ? k1 >> 16 : ((k1 & 0x7fffffff) >> 16) | 0x8000)) * 0x1b873593) & 0xffff) << 16)));
            h1 ^= k1;
            h1 = h1 << 13 | (h1 >= 0 ? h1 >> 19 : ((h1 & 0x7fffffff) >> 19) | 0x1000);
            int h1b = ((((h1 & 0xffff) * 5) + (((((h1 >= 0 ? h1 >> 16 : ((h1 & 0x7fffffff) >> 16) | 0x8000)) * 5) & 0xffff) << 16)));
            h1 = (((h1b & 0xffff) + 0x6b64) + (((((h1b >= 0 ? h1b >> 16 : ((h1b & 0x7fffffff) >> 16) | 0x8000)) + 0xe654) & 0xffff) << 16));
        }
        int k1 = 0;
        switch (remainder)
        {
            case 3:
                k1 ^= ((int) key[i + 2] & 0xff) << 16;
            case 2:
                k1 ^= ((int) key[i + 1] & 0xff) << 8;
            case 1:
                k1 ^= ((int) key[i] & 0xff);
                k1 = (((k1 & 0xffff) * 0xcc9e2d51) + (((((k1 >= 0 ? k1 >> 16 : ((k1 & 0x7fffffff) >> 16) | 0x8000)) * 0xcc9e2d51) & 0xffff) << 16));
                k1 = k1 << 15 | (k1 >= 0 ? k1 >> 17 : ((k1 & 0x7fffffff) >> 17) | 0x4000);
                k1 = (((k1 & 0xffff) * 0x1b873593) + (((((k1 >= 0 ? k1 >> 16 : ((k1 & 0x7fffffff) >> 16) | 0x8000)) * 0x1b873593) & 0xffff) << 16));
                h1 ^= k1;
        }
        h1 ^= klen;
        h1 ^= (h1 >= 0 ? h1 >> 16 : ((h1 & 0x7fffffff) >> 16) | 0x8000);
        h1 = (((h1 & 0xffff) * 0x85ebca6b) + (((((h1 >= 0 ? h1 >> 16 : ((h1 & 0x7fffffff) >> 16) | 0x8000)) * 0x85ebca6b) & 0xffff) << 16));
        h1 ^= (h1 >= 0 ? h1 >> 13 : ((h1 & 0x7fffffff) >> 13) | 0x40000);
        h1 = ((((h1 & 0xffff) * 0xc2b2ae35) + (((((h1 >= 0 ? h1 >> 16 : ((h1 & 0x7fffffff) >> 16) | 0x8000)) * 0xc2b2ae35) & 0xffff) << 16)));
        h1 ^= (h1 >= 0 ? h1 >> 16 : ((h1 & 0x7fffffff) >> 16) | 0x8000);

        return h1;
    }
}
