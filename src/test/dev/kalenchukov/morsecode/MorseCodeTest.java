/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.morsecode;

import dev.kalenchukov.morsecode.schemes.EnglishScheme;
import dev.kalenchukov.morsecode.schemes.RussianScheme;
import org.junit.Test;

import static org.junit.Assert.*;

public class MorseCodeTest
{
	/**
	 * Проверяет кодирование русской схемы
	 */
	@Test
	public void encodeRussianScheme()
	{
		Codable code = new MorseCode(new RussianScheme());
		String result = code.encode("Эх, чужд кайф, сплющь объём вши, грызя цент.");

		assertEquals("..-.. .... --..--   ---. ..- ...- -..   -.- .- .--- ..-. --..--   ... .--. .-.. ..-- --.- -..-   --- -... .--.-. . --   .-- ---- .. --..--   --. .-. -.-- --.. .-.-   -.-. . -. - .-.-.-", result);
	}

	/**
	 * Проверяет декодирование русской схемы
	 */
	@Test
	public void decodeRussianScheme()
	{
		Codable code = new MorseCode(new RussianScheme());
		String result = code.decode("..-.. .... --..--   ---. ..- ...- -..   -.- .- .--- ..-. --..--   ... .--. .-.. ..-- --.- -..-   --- -... .--.-. . --   .-- ---- .. --..--   --. .-. -.-- --.. .-.-   -.-. . -. - .-.-.-");

		assertEquals("ЭХ, ЧУЖД КАЙФ, СПЛЮЩЬ ОБЪЕМ ВШИ, ГРЫЗЯ ЦЕНТ.", result);
	}

	/**
	 * Проверяет кодирование английской схемы
	 */
	@Test
	public void encodeEnglishScheme()
	{
		Codable code = new MorseCode(new EnglishScheme());
		String result = code.encode("The quick brown fox jumps over the lazy dog.");

		assertEquals("- .... .   --.- ..- .. -.-. -.-   -... .-. --- .-- -.   ..-. --- -..-   .--- ..- -- .--. ...   --- ...- . .-.   - .... .   .-.. .- --.. -.--   -.. --- --. .-.-.-", result);
	}

	/**
	 * Проверяет декодирование английской схемы
	 */
	@Test
	public void decodeEnglishScheme()
	{
		Codable code = new MorseCode(new EnglishScheme());
		String result = code.decode("- .... .   --.- ..- .. -.-. -.-   -... .-. --- .-- -.   ..-. --- -..-   .--- ..- -- .--. ...   --- ...- . .-.   - .... .   .-.. .- --.. -.--   -.. --- --. .-.-.-");

		assertEquals("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.", result);
	}
}