package shaslicktests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("regress")
public class AvailabilityOfItems extends TestBase {
    @Owner("Никита Шутков")
    @Severity(SeverityLevel.NORMAL)
    @Description(
            "Проверка наличия товаров категории супы со стоимостью"
    )
    @Feature("Items")
    @Test
    @DisplayName("Name of soups items and its price")
    void borsh() {
        step("Открываем главную страницу", () -> {
            Selenide.open("https://shashlik.club/");
        });
        step("Переход в раздел Супы", () -> {
            $(byText("Супы")).click();
        });
        step("наличие кнопок Добавить в корзину у всех товаров категории Супы", () -> {
            $$x("//a[@class='button product_type_simple add_to_cart_button ajax_add_to_cart']")
                    .shouldHave(size(6));
        });
        step("Наличие товара Борщ и его стоимости", () -> {
            $x("//h2[contains(text(),'Борщ')]").shouldBe(visible);
            $x("//bdi[contains(text(),'320.00')]").shouldBe(visible);
        });
        step("Наличие товара Уха по-царски и его стоимости", () -> {
            $x("//h2[contains(text(),'Уха по-царски')]").shouldBe(visible);
            $x("//bdi[contains(text(),'420.00')]").shouldBe(visible);
        });
        step("Наличие товара Солянка и его стоимости", () -> {
            $x("//h2[contains(text(),'Солянка')]").shouldBe(visible);
            $x("//bdi[contains(text(),'400.00')]").shouldBe(visible);
        });
        step("Наличие товара Суп куриный и его стоимости", () -> {
            $x("//h2[contains(text(),'Суп куриный')]").shouldBe(visible);
            $x("//bdi[contains(text(),'250.00')]").shouldBe(visible);
        });
        step("Наличие товара Харчо и его стоимости", () -> {
            $x("//h2[contains(text(),'Харчо')]").shouldBe(visible);
            $("bdi", 4).shouldHave(exactText("320.00 Р")).shouldBe(visible);
        });
        step("Наличие товара Крем суп и его стоимости", () -> {
            $x("//h2[contains(text(),'Крем суп с шампиньонами')]").shouldBe(visible);
            $x("//bdi[contains(text(),'360.00')]").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Name of bakery items and its price")
    @Owner("Никита Шутков")
    @Description("Наличие товаров категории Выпечка с ценой")
    @Feature("Items")
    @Severity(SeverityLevel.NORMAL)
    void vypechka() {
        step("Открываем главную страницу", () -> {
            Selenide.open("https://shashlik.club/");
        });
        step("Переход в раздел Выпечка", () -> {
            $(byText("Выпечка")).click();
        });
        step("наличие кнопок Добавить в корзину у всех товаров категории Выпечка", () -> {
            $$x("//a[@class='button product_type_simple add_to_cart_button ajax_add_to_cart']")
                    .shouldHave(size(4));
        });
        step("Наличие товара Хачапури по Аджарски и его стоимости", () -> {
            $x("//h2[contains(text(),'Хачапури по Аджарски')]").shouldBe(visible);
            $x("//bdi[contains(text(),'350.00')]").shouldBe(visible);
        });
        step("Наличие товара Хачапури по Аджарски с двумя яйцами его стоимости", () -> {
            $x("//h2[contains(text(),'Хачапури по Аджарски с двумя яйцами')]").shouldBe(visible);
            $x("//bdi[contains(text(),'470.00')]").shouldBe(visible);
        });
        step("Наличие товара Хачапури по Имеретински и его стоимости", () -> {
            $x("//h2[contains(text(),'Хачапури по Имеретински')]").shouldBe(visible);
            $x("//bdi[contains(text(),'400.00')]").shouldBe(visible);
        });
        step("Наличие товара Хачапури по Мегрельски и его стоимости", () -> {
            $x("//h2[contains(text(),'Хачапури по Мегрельски')]").shouldBe(visible);
            $x("//bdi[contains(text(),'450.00')]").shouldBe(visible);
        });
    }

    @Test
    @Owner("Никита Шутков")
    @Description("Содержимое саджест листа Блюда на мангале")
    @DisplayName("Dishes on the grill")
    @Feature("Items")
    @Severity(SeverityLevel.CRITICAL)
    void assortiment() {
        step("Открываем главную страницу", () -> {
            Selenide.open("https://shashlik.club/");
        });
        step("Саджест лист в верхнем меню скрыт до наведения курсора на Блюда на мангале", () -> {
            $x("//a[@href='https://shashlik.club/category/blyuda-na-mangale/assorti-shashlyka/']")
                    .shouldNot(appear).shouldBe(hidden);
            $x("//a[@href='https://shashlik.club/category/blyuda-na-mangale/shashlyk-iz-baraniny/']")
                    .shouldNot(appear).shouldBe(hidden);
            $x("//a[@href='https://shashlik.club/category/blyuda-na-mangale/shashlyk-iz-svininy/']")
                    .shouldNot(appear).shouldBe(hidden);
            $x("//a[@href='https://shashlik.club/category/blyuda-na-mangale/shashlyk-iz-telyatiny/']")
                    .shouldNot(appear).shouldBe(hidden);
            $x("//a[@href='https://shashlik.club/category/blyuda-na-mangale/shashlyk-iz-kuritsy/']")
                    .shouldNot(appear).shouldBe(hidden);
            $x("//a[@href='https://shashlik.club/category/blyuda-na-mangale/shashlyk-iz-ryby/']")
                    .shouldNot(appear).shouldBe(hidden);
            $x("//a[@href='https://shashlik.club/category/garniry/']")
                    .shouldNot(appear).shouldBe(hidden);
        });
        step("При наведении курсора на Блюда на мангале в верхнем меню саджест лист появляется", () -> {
            $x("//a[@href='https://shashlik.club/category/blyuda-na-mangale/']").hover();
            $x("//a[@href='https://shashlik.club/category/blyuda-na-mangale/assorti-shashlyka/']")
                    .should(appear).shouldBe(enabled);
            $x("//a[@href='https://shashlik.club/category/blyuda-na-mangale/shashlyk-iz-baraniny/']")
                    .should(appear).shouldBe(enabled);
            $x("//a[@href='https://shashlik.club/category/blyuda-na-mangale/shashlyk-iz-svininy/']")
                    .should(appear).shouldBe(enabled);
            $x("//a[@href='https://shashlik.club/category/blyuda-na-mangale/shashlyk-iz-telyatiny/']")
                    .should(appear).shouldBe(enabled);
            $x("//a[@href='https://shashlik.club/category/blyuda-na-mangale/shashlyk-iz-kuritsy/']")
                    .should(appear).shouldBe(enabled);
            $x("//a[@href='https://shashlik.club/category/blyuda-na-mangale/shashlyk-iz-ryby/']")
                    .should(appear).shouldBe(enabled);
            $x("//a[@href='https://shashlik.club/category/garniry/']")
                    .should(appear).shouldBe(enabled);
        });
    }

    @Test
    @Owner("Никита Шутков")
    @Description("Наличие товаров категории Ассорти шашлыка с ценой")
    @DisplayName("Assorti of shashlick")
    @Feature("Items")
    @Severity(SeverityLevel.NORMAL)
    void assortiShashlick() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
            Selenide.open("https://shashlik.club/");
        });
        step("Навести курсор на Блюда на мангале для появления саджест листа", () -> {
            $x("//a[@href='https://shashlik.club/category/blyuda-na-mangale/']").hover();
            $x("//a[@href='https://shashlik.club/category/blyuda-na-mangale/assorti-shashlyka/']")
                    .should(appear).shouldBe(visible);
        });
        step("Клик на появившийся саджест Ассорти шашлыка", () -> {
            $x("//a[@href='https://shashlik.club/category/blyuda-na-mangale/assorti-shashlyka/']").click();
        });
        step("наличие кнопок Добавить в корзину у всех товаров категории Выпечка", () -> {
            $$x("//a[@class='button product_type_simple add_to_cart_button ajax_add_to_cart']")
                    .shouldHave(size(6));
        });
        step("Наличие товара Ассорти от шефа и его стоимости", () -> {
            $x("//h2[contains(text(),'Ассорти От шефа')]").shouldBe(visible);
            $x("//bdi[contains(text(),'5,200.00')]").shouldBe(visible);
        });
        step("Наличие товара Ассорти свинины и его стоимости", () -> {
            $x("//h2[contains(text(),'Ассорти свинины')]").shouldBe(visible);
            $x("//bdi[contains(text(),'2,900.00')]").shouldBe(visible);
        });
        step("Наличие товара Ассорти куриное и его стоимости", () -> {
            $x("//h2[contains(text(),'Ассорти куриное')]").shouldBe(visible);
            $x("//bdi[contains(text(),'2,550.00')]").shouldBe(visible);
        });
        step("Наличие товара Ассорти баранины и его стоимости", () -> {
            $x("//h2[contains(text(),'Ассорти баранины')]").shouldBe(visible);
            $x("//bdi[contains(text(),'5,400.00')]").shouldBe(visible);
        });
        step("Наличие товара Ассорти мякоти и его стоимости", () -> {
            $x("//h2[contains(text(),'Ассорти мякоти')]").shouldBe(visible);
            $x("//bdi[contains(text(),'3,360.00')]").shouldBe(visible);
        });
        step("Наличие товара Ассорти люля и его стоимости", () -> {
            $x("//h2[contains(text(),'Ассорти люля')]").shouldBe(visible);
            $x("//bdi[contains(text(),'1,340.00')]").shouldBe(visible);
        });
    }

    @Test
    @Owner("Никита Шутков")
    @Description("Наличие товаров категории Шашлык из баранины с ценой")
    @DisplayName("Assorti of baranina")
    @Feature("Items")
    @Severity(SeverityLevel.NORMAL)
    void shashlickIsBaraniny() {
        step("Открываем главную страницу", () -> {
            Selenide.open("https://shashlik.club/");
        });
        step("Навести курсор на Блюда на мангале для появления саджест листа", () -> {
            $x("//a[@href='https://shashlik.club/category/blyuda-na-mangale/']").hover();
            $x("//a[@href='https://shashlik.club/category/blyuda-na-mangale/shashlyk-iz-baraniny/']")
                    .should(appear).shouldBe(visible);
        });
        step("Клик на Шашлык из баранины из саджест листа для перехода на страницу", () -> {
            $x("//a[@href='https://shashlik.club/category/blyuda-na-mangale/shashlyk-iz-baraniny/']")
                    .scrollTo()
                    .click();
        });
        step("Наличие товара Мякоть баранины и его стоимости", () -> {
            $("h2").shouldHave(text("Мякоть баранины")).shouldBe(visible);
            $("bdi").shouldHave(text("540.00 ")).shouldBe(visible);
        });
        step("Наличие товара Каре ягненка и его стоимости", () -> {
            $("h2", 1).shouldHave(text("Каре ягненка")).shouldBe(visible);
            $("bdi", 1).shouldHave(text("800.00")).shouldBe(visible);
        });
        step("Наличие товара Каре ягненка и его стоимости", () -> {
            $("h2", 2).shouldHave(text("Баранья корейка")).shouldBe(visible);
            $("bdi", 2).shouldHave(text("560.00")).shouldBe(visible);
        });
        step("Наличие товара Шашлык из седла баранины и его стоимости", () -> {
            $("h2", 3).shouldHave(text("Шашлык из седла баранины")).shouldBe(visible);
            $("bdi", 3).shouldHave(text("480.00")).shouldBe(visible);
        });
        step("Наличие товара Баранье сердце и его стоимости", () -> {
            $("h2", 4).shouldHave(text("Баранье сердце")).shouldBe(visible);
            $("bdi", 4).shouldHave(text("380.00")).shouldBe(visible);
        });
        step("Наличие товара Бараньи ребра и его стоимости", () -> {
            $("h2", 5).shouldHave(text("Бараньи ребра")).shouldBe(visible);
            $("bdi", 5).shouldHave(text("360.00")).shouldBe(visible);
        });
        step("Наличие товара Баранья печень с курдюком и его стоимости", () -> {
            $("h2", 6).shouldHave(text("Баранья печень с курдюком")).shouldBe(visible);
            $("bdi", 6).shouldHave(text("350.00")).shouldBe(visible);
        });
        step("Наличие товара Баранья печень с курдюком и его стоимости", () -> {
            $("h2", 7).shouldHave(text("Люля из баранины")).shouldBe(visible);
            $("bdi", 7).shouldHave(text("300.00")).shouldBe(visible);
        });
        step("Наличие товара Ассорти баранины и его стоимости", () -> {
            $("h2", 8).shouldHave(text("Ассорти баранины")).shouldBe(visible);
            $("bdi", 8).shouldHave(text("4,200.00")).shouldBe(visible);
        });
    }

    @Test
    @Owner("Никита Шутков")
    @Description("Наличие товаров категории Шашлык из свинины с ценой")
    @DisplayName("Assorti of shashlick of svinina")
    @Feature("Items")
    @Severity(SeverityLevel.NORMAL)
    void shashlickIsSvininy() {
        step("Открываем главную страницу", () -> {
            Selenide.open("https://shashlik.club/");
        });
        step("Навести курсор на Блюда на мангале для появления саджест листа", () -> {
            $x("//a[@href='https://shashlik.club/category/blyuda-na-mangale/']").hover();
            $x("//a[@href='https://shashlik.club/category/blyuda-na-mangale/shashlyk-iz-svininy/']")
                    .should(appear).shouldBe(enabled);
        });
        step("Клик на Шашлык из свинины из саджест листа", () -> {
            $x("//a[@href='https://shashlik.club/category/blyuda-na-mangale/shashlyk-iz-svininy/']")
                    .scrollTo()
                    .click();
        });
        step("Наличие товара Свиная шея и его стоимости", () -> {
            $x("//h2[contains(text(),'Свиная шея')]").shouldBe(visible);
            $x("//bdi[contains(text(),'430.00')]").shouldBe(visible);
        });
        step("Наличие товара Мякоть свинины и его стоимости", () -> {
            $x("//h2[contains(text(),'Мякоть свинины')]").shouldBe(visible);
            $x("//bdi[contains(text(),'330.00')]").shouldBe(visible);
        });
        step("Наличие товара Свиная корейка и его стоимости", () -> {
            $x("//h2[contains(text(),'Свиная корейка')]").shouldBe(visible);
            $("bdi", 2).shouldHave(exactText("430.00 Р")).shouldBe(visible);
        });
        step("Наличие товара Свиные ребра и его стоимости", () -> {
            $x("//h2[contains(text(),'Свиные ребра')]").shouldBe(visible);
            $x("//bdi[contains(text(),'440.00')]").shouldBe(visible);
        });
        step("Наличие товара Люля из свинины", () -> {
            $x("//h2[contains(text(),'Люля из свинины')]").shouldBe(visible);
            $x("//bdi[contains(text(),'290.00')]").shouldBe(visible);
        });
        step("Наличие товара Ассорти свинины и его стоимости", () -> {
            $x("//h2[contains(text(),'Ассорти свинины')]").shouldBe(visible);
            $x("//bdi[contains(text(),'2,900.00')]").shouldBe(visible);
        });
    }

    @Test
    @Owner("Никита Шутков")
    @Description("Наличие категории товаров на главной странице не в табе")
    @DisplayName("display types of items in main id")
    @Feature("Items")
    @Severity(SeverityLevel.CRITICAL)
    void link_2() {
        step("Открываем главную страницу", () -> {
            Selenide.open("https://shashlik.club/");
        });
        step("Проверяем наличие категории Блюда на мангале", () -> {
            $(".blocks-gallery-item__caption")
                    .shouldHave(text("Блюда на Мангале"))
                    .shouldBe(visible)
                    .shouldBe(enabled);
        });
        step("Проверяем наличие категории Салаты и закуски", () -> {
            $(".blocks-gallery-item__caption", 1)
                    .shouldHave(text("Салаты и Закуски"))
                    .shouldBe(visible)
                    .shouldBe(enabled);
        });
        step("Проверяем наличие категории Выпечка", () -> {
            $(".blocks-gallery-item__caption", 2)
                    .shouldHave(text("Выпечка"))
                    .shouldBe(visible)
                    .shouldBe(enabled);
        });
        step("Проверяем наличие категории Наш Партнер ЦС Феникс", () -> {
            $(".blocks-gallery-item__caption", 3)
                    .shouldHave(text("Наш Партнер ЦС Феникс"))
                    .shouldBe(visible)
                    .shouldBe(enabled);
        });
    }
}

