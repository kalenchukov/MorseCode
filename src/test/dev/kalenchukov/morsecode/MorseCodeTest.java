/*
 * Copyright © 2022-2023 Алексей Каленчуков
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

import dev.kalenchukov.morsecode.types.Language;
import dev.kalenchukov.morsecode.schemes.EnglishScheme;
import dev.kalenchukov.morsecode.schemes.RussianScheme;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Класс проверки методов класса {@link MorseCode}.
 *
 * @author Алексей Каленчуков
 */
public class MorseCodeTest
{
	/**
	 * Проверка метода {@link MorseCode#encode(String)} со схемой {@link RussianScheme}.
	 */
	@Test
	public void encodeRussianScheme()
	{
		String value = "Эх, чужд кайф, сплющь объём вши, грызя цент.";
		String expectedString = "..-.. .... --..--   ---. ..- ...- -..   -.- .- .---" +
				" ..-. --..--   ... .--. .-.. ..-- --.- -..-   --- -... .--.-." +
				" . --   .-- ---- .. --..--   --. .-. -.-- --.. .-.-   -.-. . -. - .-.-.-";

		MorseCodable morseCode = new MorseCode(Language.RUSSIAN);
		String actualString = morseCode.encode(value);

		assertThat(actualString).isEqualTo(expectedString);
	}

	/**
	 * Проверка метода {@link MorseCode#decode(String)} со схемой {@link RussianScheme}.
	 */
	@Test
	public void decodeRussianScheme()
	{
		String value = "..-.. .... --..--   ---. ..- ...- -..   -.- .- .---" +
				" ..-. --..--   ... .--. .-.. ..-- --.- -..-" +
				"   --- -... .--.-. . --   .-- ---- .. --..--" +
				"   --. .-. -.-- --.. .-.-   -.-. . -. - .-.-.-";
		String expectedString = "ЭХ, ЧУЖД КАЙФ, СПЛЮЩЬ ОБЪЕМ ВШИ, ГРЫЗЯ ЦЕНТ.";

		MorseCodable morseCode = new MorseCode(Language.RUSSIAN);
		String actualString = morseCode.decode(value);

		assertThat(actualString).isEqualTo(expectedString);
	}

	/**
	 * Проверка метода {@link MorseCode#encode(String)} со схемой {@link EnglishScheme}.
	 */
	@Test
	public void encodeEnglishScheme()
	{
		String value = "The quick brown fox jumps over the lazy dog.";
		String expectedString = "- .... .   --.- ..- .. -.-. -.-   -... .-. ---" +
				" .-- -.   ..-. --- -..-   .--- ..- -- .--. ...   --- ...-" +
				" . .-.   - .... .   .-.. .- --.. -.--   -.. --- --. .-.-.-";

		MorseCodable morseCode = new MorseCode(Language.ENGLISH);
		String actualString = morseCode.encode(value);

		assertThat(actualString).isEqualTo(expectedString);
	}

	/**
	 * Проверка метода {@link MorseCode#decode(String)} со схемой {@link EnglishScheme}.
	 */
	@Test
	public void decodeEnglishScheme()
	{
		String value = "- .... .   --.- ..- .. -.-. -.-   -... .-. --- .-- -." +
				"   ..-. --- -..-   .--- ..- -- .--. ...   --- ...- . .-." +
				"   - .... .   .-.. .- --.. -.--   -.. --- --. .-.-.-";
		String expectedString = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.";

		MorseCodable morseCode = new MorseCode(Language.ENGLISH);
		String actualString = morseCode.decode(value);

		assertThat(actualString).isEqualTo(expectedString);
	}
}