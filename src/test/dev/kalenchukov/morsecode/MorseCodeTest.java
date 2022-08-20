/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
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