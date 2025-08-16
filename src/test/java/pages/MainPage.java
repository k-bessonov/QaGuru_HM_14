package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final SelenideElement searchButton = $(".search-catalog__block"),
            setInput = $(".search-catalog__input"),
            searchResult = $(".searching-results__title"),
            travelLink = $(".simple-menu__switch-item.j-avia"),
            travelResult = $(".block-slider_heading__v8pB0"),
            negativeSearchResult = $(".not-found-search__title"),
            basketButton = $(".navbar-pc__icon--basket"),
            emptyBasketButtonCheck = $(".basket-empty__title"),
            addToBasketButton = $(".product-card__add-basket"),
            notEmptyBasketButtonCheck= $(".accordion__goods-count");

    public void openMainPage() {
        open("/");
        $(".simple-menu__link.simple-menu__link--business-block.j-business")
                .shouldHave(text("Для бизнеса"));

    }

    public void searchButton() {
        searchButton.click();
    }

    public void setInput(String value) {
        setInput.setValue(value).pressEnter();

    }

    public void searchResult(String value) {
        searchResult.shouldHave(text(value));
    }

    public void negativeSearchResult(String value) {
        negativeSearchResult.shouldHave(text("Ничего не нашлось по запросу «" + value + "»"));
    }

    public void travelLink() {
        travelLink.click();
        switchTo().window(1);

    }

    public void travelLinkCheck() {
        travelResult.shouldHave(text("Популярные направления"));
    }

    public void basketButton() {
        basketButton.click();
    }

    public void addToBasketButton() {
        addToBasketButton.click();
    }

    public void emptyBasketButtonCheck() {
        emptyBasketButtonCheck.shouldHave(text("В корзине пока пусто"));
    }

    public void notEmptyBasketButtonCheck() {
        notEmptyBasketButtonCheck.shouldHave(text("1 товар"));
    }

}
