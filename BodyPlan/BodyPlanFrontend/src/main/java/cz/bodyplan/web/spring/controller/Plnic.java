package cz.bodyplan.web.spring.controller;

import java.util.Random;

public class Plnic {
	public static String generateString(String characters, int length)
	{
	    char[] text = new char[length];
	    for (int i = 0; i < length; i++)
	    {
	        text[i] = characters.charAt(new Random().nextInt(characters.length()));
	    }
	    return new String(text);
	}

}
