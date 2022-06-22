public class CSS_selector {
    public static void ByCSS() {
        // $$("body") - поиск по тегу body
        // $$("#mini-suggest__params-js") - поиск по id mini-suggest__params-js
        // $$(".safety-filter") - поиск по классу со значением safety-filter
        // $$("[href='#search-result-aside']") - поиск по атрибуту href и его значению #search-result-aside
        // $$("[href]") - поиск списка всех элементов с атрибутом href
        // $$("link[href]") - поиск списка всех элементов c тегом link с атрибутом href
        // $$("div[class*='igure']") - поиск элементов с тегом div, атрибутом class, содержащим в своём значении igure
        // $$("div[class^='obje']") - поиск элемента с тегом div, атрибутом class, значение которого начинается на obje
        // $$("div[class$='mat_122x122']") - поиск элемента с тегом div, атрибутом class, значение которого оканчивается на mat_122x122
        // $$(".main__distr-popup.serp.i-bem") - поиск элемента по трём классам main__distr-popup serp i-bem
        // $$(".main__distr-popup.serp[data-bem*='serp']") - поиск по двум классам и атрибуту, содержащему слово serp
        // $$("div:not(.col)") - поиск элементов с тегом div, не содержащих класс col
        // $$("a:not([href^='http'])") - поиск всех ссылок, не содержащих в атрибуте href начало http
        // $$("div.entity-search__header-wrapper div.entity-search__figures") - поиск элемента div с классом
        //                                                                      entity-search__header-wrapper
        //                                                                      вложенным в него div c классом entity-search__figures,
        //                                                                      степень вложенности не определена
        // $$("div.entity-search__header-wrapper > div.entity-search__figures") - поиск вложенного элемента
        // $$("ul li:first-child") - поиск первого ребёнка li у элемента ul
        // $$("ul li:last-child") - поиск последнего ребёнка li у элемента ul
        // $$("ul li:nth-child(2)") - поиск второго ребёнка li у элемента ul
    }
}
