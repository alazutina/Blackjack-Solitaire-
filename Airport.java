
package project2;

// Вспомогательный класс для хранения данных о прилетах и вылетах. Для ответа на 4-6 вопросы
public class Airport{
    
    String airportType; // тип источник или приемник
    String airportId; // id аэропорта
    Integer count; // количество
    
    public Airport(String airportType, String airportId){
    this.airportId = airportId;
    this.airportType = airportType;
    this.count = 0;
    }
    
    public Airport(String airportType, String airportId, Integer count){
    this.airportId = airportId;
    this.airportType = airportType;
    this.count = count;
    }
    
    public String getAirportType(){
        return this.airportType;
    }
    
    public String getAirportId(){
        return this.airportId;
    }
    
    public Integer getCount(){
        return this.count;
    }
    
    
    
    
}
