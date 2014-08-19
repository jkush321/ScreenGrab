package net.infacraft.txtjpg;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.google.common.base.CharMatcher;
import com.google.common.io.BaseEncoding;

public class Main {
	public static void main(String args[]){
		log("==========================");
		log("=        Txt->JPG        =");
		log("= by jkush321 and Portal =");
		log("==========================");
		log("");
		
		int successes = 0;
		
		if (args.length==0)
		{
			log("No input, exiting.");
			return;
		}
		for (String inFile : args)
		{
			String outFile = inFile.replaceAll(".txt", ".jpg");
			if (inFile.endsWith(".txt"))
			{
				Path inFilePath = Paths.get(inFile);
				try
				{
					String input = new String(Files.readAllBytes(inFilePath));
					input = CharMatcher.WHITESPACE.removeFrom(input);
					byte[] output = BaseEncoding.base64().decode(input);
					Files.write(Paths.get(outFile), output, StandardOpenOption.CREATE);
					logf("Decoded [%s] to [%s]",inFile,outFile);
					successes++;
				}
				catch (Exception e)
				{
					log("Error reading file: " + inFile);
					e.printStackTrace();
				}
			}
			else
			{
				log("File " +inFile+ " does not end with '.txt', can not read.");
			}
		}
		logf("Successfully decoded %d file(s).",successes);
	}
	public static void log(String s)
	{
		System.out.println(s);
	}
	public static void logf(String s, Object... obj)
	{
		log(String.format(s,obj));
	}
}