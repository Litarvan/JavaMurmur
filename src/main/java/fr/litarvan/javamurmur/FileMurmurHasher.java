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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOError;
import java.io.IOException;

/**
 * The File Murmur 3 hasher
 *
 * This is the Murmur3 file hasher
 *
 * @version 1.0.0
 * @author Litarvan
 */
public class FileMurmurHasher extends MurmurHasher<File>
{
    @Override
    protected byte[] getBytes(File toHash) throws IOError
    {
        byte[] bytes = new byte[(int) toHash.length()];
        FileInputStream in = null;

        try
        {
            in = new FileInputStream(toHash);
            in.read(bytes);
        }
        catch(IOException e)
        {
            throw new IOError(e);
        }
        finally
        {
            if (in != null)
                try
                {
                    in.close();
                }
                catch (IOException ignored)
                {
                }
        }

        return bytes;
    }
}
