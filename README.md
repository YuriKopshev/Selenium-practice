# Практика по курсу Selenium 3.0

## Установка учебного приложения
Для выполнения домашних заданий потребуется учебное приложение, 

Запуск в docker-контейнере:

` docker pull barancev/web-apps-for-courses `

` docker run -d --name webapps -p 80:80 --restart=always barancev/web-apps-for-courses `

### Задание 1. Сделать сценарий логина:
Сделать сценарий для логина в панель администрирования учебного приложения http://localhost/litecart/admin/.

[Решение задания 1](https://github.com/YuriKopshev/Selenium-practice/blob/master/src/test/java/LiteCart.java)

### Задание 2. Сделать сценарий, проходящий по всем разделам админки

1) входит в панель администратора http://localhost/litecart/admin

2) прокликивает последовательно все пункты меню слева, включая вложенные пункты

3) для каждой страницы проверяет наличие заголовка (то есть элемента с тегом h1)

[Решение задания 2](https://github.com/YuriKopshev/Selenium-practice/blob/master/src/test/java/LiteCartTabTests.java)

### Задание 3. Сделать сценарий, проверяющий наличие стикеров у товаров
Сделать сценарий, проверяющий наличие стикеров у всех товаров в учебном приложении litecart на главной странице. 

Стикеры -- это полоски в левом верхнем углу изображения товара, на которых написано New или Sale или что-нибудь другое. 

Сценарий должен проверять, что у каждого товара имеется ровно один стикер.

[Решение задания 3](https://github.com/YuriKopshev/Selenium-practice/blob/master/src/test/java/StickerTests.java)

### Задание 4. Проверить сортировку стран и геозон в админке

Сделать сценарии, которые проверяют сортировку стран и геозон (штатов) в учебном приложении litecart.

1) на странице http://localhost/litecart/admin/?app=countries&doc=countries
   а) проверить, что страны расположены в алфавитном порядке

   б) для тех стран, у которых количество зон отлично от нуля -- открыть страницу этой страны и там проверить, что зоны расположены в алфавитном порядке

2) на странице http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones

   зайти в каждую из стран и проверить, что зоны расположены в алфавитном порядке

[Решение задания 4](https://github.com/YuriKopshev/Selenium-practice/blob/master/src/test/java/TestCountryGeoZone.java)