# Журнал изменений
## vX.X.X - XX.XX.XXXX
### Изменено
* Переименован пакет resources -> types.

## v1.4.0 - 08.07.2023
### Изменено
* Изменена версия Java на 17.

## v1.3.0 - 14.05.2023
### Добавлено
* Добавлен метод NumberScheme.hashCode().
* Добавлен метод SpecialScheme.hashCode().
* Добавлен метод NumberScheme.equals(Object).
* Добавлен метод SpecialScheme.equals(Object).
* В module-info.java добавлен пакет *.morsecode.resources.
* Добавлен класс AbstractScheme.
* Добавлен конструктор MorseCode.MorseCode(Schemes).

### Изменено
* Перемещён пакет *.morsecode.schemes.resources -> *.morsecode.resources.
* Переименован интерфейс Codable -> MorseCodable.
* Переименовано перечисление Schemes -> Language.

### Удалено
* Удалён конструктор MorseCode.MorseCode(Schematic).

## v1.2.0 - 12.02.2023
### Добавлено
* Добавлено перечисление схем сопоставления Schemes.
* Добавлен метод Schematic.equals(Object).
* Добавлен метод Schematic.hashCode().
* Добавлен AUTHOR.MD.
* Добавлен INSTALL.MD.
* Добавлен CHANGELOG.MD.

### Изменено
* Обновлён README.MD.
* Изменён конструктор MorseCode.MorseCode(Schematic).

## v1.1.0 - 16.10.2022
### Добавлено
* Добавлен плагин maven-assembly в pom.xml.
* Добавлен плагин maven-compiler в pom.xml.
* Добавлен плагин maven-dependency в pom.xml.
* Добавлен плагин maven-javadoc в pom.xml.
* Добавлен плагин maven-source в pom.xml.

### Изменено
* Обновлён README.MD.
* Переименован класс GraphScheme -> SpecialScheme.
