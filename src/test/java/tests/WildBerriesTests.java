package tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;


import static data.TestData.*;
import static io.qameta.allure.Allure.step;

public class WildBerriesTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    void successfulSearchTest() {

        step("Открываем сайт", () -> mainPage.openMainPage());

        step("Заполняем поиск", () -> {
            mainPage.searchButton();
            mainPage.setInput(goodSearchValue);
        });

        step("Проверяем результат поиска", () -> mainPage.searchResult(goodSearchValue));
    }

    @Test
    void negativeSearchTest() {

        step("Открываем сайт", () -> mainPage.openMainPage());

        step("Заполняем поиск", () -> {
            mainPage.searchButton();
            mainPage.setInput(badSearchValue);
        });

        step("Проверяем результат поиска", () -> mainPage.negativeSearchResult(badSearchValue));
    }


    @Test
    void successfulTravelTest() {

        step("Открываем сайт", () -> mainPage.openMainPage());

        step("Переходим на сайт путешествий", () -> mainPage.travelLink());

        step("Проверяем что переход был выполнен", () -> mainPage.travelLinkCheck());

    }

    @Test
    void successfulEmptyBasketTest() {

        step("Открываем сайт", () -> mainPage.openMainPage());

        step("Переходим в корзину незарегистрированного пользователя", () -> mainPage.basketButton());

        step("Проверяем что корзина пустая", () -> mainPage.emptyBasketButtonCheck());
    }

    @Test
    void successfulNotEmptyBasketTest() {

        step("Открываем сайт", () -> mainPage.openMainPage());

        step("Заполняем поиск", () -> {
            mainPage.searchButton();
            mainPage.setInput(goodSearchValue);
        });

        step("Добавляем в корзину", () -> mainPage.addToBasketButton());

        step("Переходим в корзину незарегистрированного пользователя", () -> mainPage.basketButton());

        step("Проверяем что в корзине появился 1 товар", () -> mainPage.notEmptyBasketButtonCheck());
    }

}
