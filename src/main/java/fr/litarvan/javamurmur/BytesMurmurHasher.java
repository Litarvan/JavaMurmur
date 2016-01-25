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

/**
 * The Byte Array Murmur 3 hasher
 *
 * This is the Murmur3 byte array hasher
 *
 * @version 1.0.0
 * @author Litarvan
 */
public class BytesMurmurHasher extends MurmurHasher<byte[]>
{
    @Override
    protected byte[] getBytes(byte[] toHash)
    {
        return toHash;
    }
}

