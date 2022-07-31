/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.morsecode.schemes;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс схемы сопоставления букв русского алфавита и сигналов.
 */
public class RussianScheme implements Schematic
{
	/**
	 * Схема сопоставления символов с сигналами.
	 */
	@NotNull
	private static final Map<@NotNull String, @NotNull List<@NotNull String>> SCHEME = new LinkedHashMap<>();

	static
	{
		SCHEME.put("А", List.of(".-"));
		SCHEME.put("Б", List.of("-..."));
		SCHEME.put("В", List.of(".--"));
		SCHEME.put("Г", List.of("--."));
		SCHEME.put("Д", List.of("-.."));
		SCHEME.put("Е", List.of("."));
		SCHEME.put("Ё", List.of("."));
		SCHEME.put("Ж", List.of("...-"));
		SCHEME.put("З", List.of("--.."));
		SCHEME.put("И", List.of(".."));
		SCHEME.put("Й", List.of(".---"));
		SCHEME.put("К", List.of("-.-"));
		SCHEME.put("Л", List.of(".-.."));
		SCHEME.put("М", List.of("--"));
		SCHEME.put("Н", List.of("-."));
		SCHEME.put("О", List.of("---"));
		SCHEME.put("П", List.of(".--."));
		SCHEME.put("Р", List.of(".-."));
		SCHEME.put("С", List.of("..."));
		SCHEME.put("Т", List.of("-"));
		SCHEME.put("У", List.of("..-"));
		SCHEME.put("Ф", List.of("..-."));
		SCHEME.put("Х", List.of("...."));
		SCHEME.put("Ц", List.of("-.-."));
		SCHEME.put("Ч", List.of("---."));
		SCHEME.put("Ш", List.of("----"));
		SCHEME.put("Щ", List.of("--.-"));
		SCHEME.put("Ъ", List.of(".--.-."));
		SCHEME.put("Ы", List.of("-.--"));
		SCHEME.put("Ь", List.of("-..-"));
		SCHEME.put("Э", List.of("..-.."));
		SCHEME.put("Ю", List.of("..--"));
		SCHEME.put("Я", List.of(".-.-"));
	}

	/**
	 * @see Schematic#getScheme()
	 */
	@Unmodifiable
	@NotNull
	@Override
	public Map<@NotNull String, @NotNull List<@NotNull String>> getScheme()
	{
		return Collections.unmodifiableMap(RussianScheme.SCHEME);
	}
}
