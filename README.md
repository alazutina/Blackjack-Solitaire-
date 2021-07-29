# dswa
**Обработка массива данных на примере авиакомпаний (Data Science with Airlines)**

1.Описание проекта

+Проект служит для закрепления навыков работы с файловой системой, фундаментальными структурами данных (в частности, классы HashMap, ArrayList и т.д.) и приемами функционального программирования для задач хранения, поиска и обработки информации.
+Источника информации - файл flights.csv, курсант должен создать Java-приложение и ответить на нижеперечисленные вопросы.
+Вопросы: 
-Q1: У какой авиакомпании наибольший процент отмененных рейсов (Cancelled)? Ответом должен быть двухбуквенный код авиаперевозчика (UniqueCarrier) и процентная доля отмененных рейсов (например: AA, 1.22%). Процентная доля вычисляется как отношение отмененных рейсов к общему числу совершенных рейсов.
-Q2: По какой причине рейсы отменялись чаще всего? Ответом должен быть однобуквенный код.
--Q3: Какой именно борт (TailNum) налетал наибольшее число миль? Ответом должен быть полный
номер борта (например: N775AJ).
-Q4: Какой аэропорт был самым загруженным с точки зрения количества прибывающих и
вылетающих рейсов? Ответом должен быть идентификатор OriginAirportID (например:
12478).
-Q5: Какой аэропорт был самым активным «источником» (source) рейсов? Этот показатель
вычисляется как разница между прибывающими и вылетающими рейсами. Ответом должен
быть идентификатор OriginAirportID (например: 12478). В ответе на этот вопрос не должны
участвовать отменные рейсы.
-Q6: Какой аэропорт был самым активным «поглотителем» (sink) рейсов? Этот показатель
вычисляется аналогично предыдущему. Ответом должен быть идентификатор DestAirportID
(например: 12478). Как и в ответе на вопрос Q5, отмененные рейсы учитываться не должны.
-Q7: Сколько рейсов компании American Airlines (UniqueCarrier ‘AA’) оказались задержаны на 60
минут и более? Если задержался и вылет и прибытие, учитывается сумма этих задержек. Ответом
должно быть целое число.
-Q8: Задержки иногда удается наверстать (т.е. рейс сумел прибыть вовремя или даже с опережением
графика). Какая из таких наверстанных задержек оказалась самой большой? В ответе указать
дату (DayOfMonth), задержку вылета (DepDelay ) в минутах и номер борта (TailNum). Например:
10,30,N947JB.
-Q9: Задержки иногда удается наверстать (т.е. рейс сумел прибыть вовремя или даже с опережением графика). Найти самое большое опережение графика. В ответе указать дату (DayOfMonth), задержку вылета (DepDelay ) в минутах и номер борта (TailNum). Например: 10,30,N947JB.
