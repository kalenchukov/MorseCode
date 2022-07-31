/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.morsecode;

import org.jetbrains.annotations.NotNull;

/**
 * Интерфейс для реализации класса кодировщика / декодировщика азбуки Морзе.
 */
public interface Codable
{
	/**
	 * Кодирует символы в сигналы.
	 *
	 * @param text Текст.
	 * @return Закодированный текст.
	 */
	@NotNull
	String encode(@NotNull String text);

	/**
	 * Декодирует сигналы в символы.
	 *
	 * @param code Код.
	 * @return Декодированный текст.
	 */
	@NotNull
	String decode(@NotNull String code);
}
