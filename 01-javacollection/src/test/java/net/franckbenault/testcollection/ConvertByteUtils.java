package net.franckbenault.testcollection;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class ConvertByteUtils {
	private static final Charset US_ASCII = Charset.forName( "US-ASCII" );
	 
	public static Object convert( final String str )
	{
	    //discard empty or too long strings as well as strings with '\0'
	    if ( str == null || str.length() == 0 || str.length() > 12 || str.indexOf( '\0') != -1 )
	        return str;
	    //encoder may be stored in ThreadLocal
	    final CharsetEncoder enc = US_ASCII.newEncoder();
	    final CharBuffer charBuffer = CharBuffer.wrap( str );
	    try {
	        final ByteBuffer byteBuffer = enc.encode( charBuffer );
	        final byte[] byteArray = byteBuffer.array();
	        if ( byteArray.length <= 12 )
	            return new Packed12( byteArray );
	        //add cases for longer strings here
	        else
	            return str;
	    } catch (CharacterCodingException e) {
	        //there are some chars not fitting to our encoding
	        return str;
	    }
	}
	 
	private static abstract class PackedBase
	{
	    protected int get( final byte[] ar, final int index )
	    {
	        return index < ar.length ? ar[ index ] : 0;
	    }
	 
	    protected abstract ByteBuffer toByteBuffer();
	 
	    protected String toString( final ByteBuffer bbuf )
	    {
	        final byte[] ar = bbuf.array();
	        //skip zero bytes at the tail of the string
	        int last = ar.length - 1;
	        while ( last > 0 && ar[ last ] == 0 )
	            --last;
	        return new String( ar, 0, last + 1, US_ASCII );
	    }
	 
	    public String toString()
	    {
	        return toString( toByteBuffer() );
	    }
	}
	 
	private static class Packed12 extends PackedBase
	{
	    private final int f1;
	    private final int f2;
	    private final int f3;
	 
	    public Packed12( final byte[] ar )
	    { //should be the same logic as in java.util.Bits.getInt, because ByteBuffer.putInt use it
	        f1 = get( ar, 3 ) | get( ar, 2 ) << 8 | get( ar, 1 ) << 16 | get( ar, 0 ) << 24;
	        f2 = get( ar, 7 ) | get( ar, 6 ) << 8 | get( ar, 5 ) << 16 | get( ar, 4 ) << 24;
	        f3 = get( ar, 11 ) | get( ar, 10 ) << 8 | get( ar, 9 ) << 16 | get( ar, 8 ) << 24;
	    }
	 
	    protected ByteBuffer toByteBuffer()
	    {
	        final ByteBuffer bbuf = ByteBuffer.allocate( 12 );
	        bbuf.putInt( f1 );
	        bbuf.putInt( f2 );
	        bbuf.putInt( f3 );
	        return bbuf;
	    }
	 
	    @Override
	    public boolean equals(Object o) {
	        if ( this == o ) return true;
	        if ( o == null || getClass() != o.getClass() ) return false;
	        Packed12 packed12 = ( Packed12 ) o;
	        return f1 == packed12.f1 && f2 == packed12.f2 && f3 == packed12.f3;
	    }
	 
	    @Override
	    public int hashCode() {
	        int result = f1;
	        result = 31 * result + f2;
	        result = 31 * result + f3;
	        return result;
	    }
	}
}
