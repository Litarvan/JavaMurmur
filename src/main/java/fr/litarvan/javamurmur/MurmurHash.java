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

public class MurmurHash
{
    private int hash;

    public MurmurHash(int hash)
    {
        this.hash = hash;
    }

    public int toInt()
    {
        return hash;
    }

    public String toString()
    {
        return toString(32);
    }

    public String toString(int base)
    {
        return Integer.toString(hash, base);
    }
}
