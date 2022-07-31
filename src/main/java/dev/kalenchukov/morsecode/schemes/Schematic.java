/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.morsecode.schemes;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.List;
import java.util.Map;

/**
 * Интерфейс для реализации схемы сопоставления символов с сигналами.
 */
public interface Schematic
{
	/**
	 * Возвращает схему сопоставления символов с сигналами.
	 *
	 * @return Коллекцию схемы сопоставления.
	 */
	@Unmodifiable
	@NotNull
	Map<@NotNull String, @NotNull List<@NotNull String>> getScheme();
}
