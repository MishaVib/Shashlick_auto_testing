package shaslicktests;

import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.DishesOnGrillPage;
import pages.MainPage;
import pages.PorkLoinPage;

import java.util.Locale;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class ShashlickSuccessOrder extends TestBase {
    Faker faker = new Faker(new Locale("ru"));
    String firstName = faker.name().firstName();
    String phoneNumber = faker.phoneNumber().phoneNumber();
    String address = faker.address().streetAddress();
    MainPage mainPage = new MainPage();
    DishesOnGrillPage dishesOnGrillPage = new DishesOnGrillPage();
    PorkLoinPage porkLoinPage = new PorkLoinPage();
    CartPage cartPage = new CartPage();


    @Test
    @Tag("acceptance")
    @Tag("order")
    @Owner("Никита Шутков")
    @Severity(SeverityLevel.BLOCKER)
    @Description(
            "Проверка успешного создания заказа шашлыка"
    )
    @Feature("Оформление заказа")
    void successOrder() {
        step("Открываем главную страницу", () -> {
            mainPage.openMainPage();
        });
        step("Наличие номера телефона и заголовка", () -> {
            mainPage.headerAndPhoneCheck();
        });
        step("Переход в раздел блюда на мангале", () -> {
            mainPage.clickDishesOnGrill();
        });
        step("Переход в товар Свиная корейка и добавляем одну штуку в корзину", () -> {
            dishesOnGrillPage.clickPorkLoin();
            porkLoinPage.clickButtonAddToCart();
        });
        step("Переход в корзину и добавление товара кликом на плюсик", () -> {
            porkLoinPage.clkickButtonViewCart();
            cartPage.clickButtonPlus();
        });
        step("Переход в оформление заказа и ввод данных для получения заказа", () -> {
            $x("//a[@href='https://shashlik.club/checkout/']").click();
            $("#billing_first_name").setValue(firstName);
            $("#billing_phone").setValue(phoneNumber);
            $("#shipping_address_1").setValue(address);
        });
        step("Выбор самовывоза и подтверждение заказа", () -> {
            $(byText("Самовывоз")).click();
            $(byText("Подтвердить заказ")).click();
        });
    }
}

