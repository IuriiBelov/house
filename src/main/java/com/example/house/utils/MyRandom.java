package com.example.house.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MyRandom {
    private static String firstNames[] = {
            "Alexey", "Andrey", "Alexander",
            "Bogdan", "Boris", "Bulat",
            "Victor", "Vladimir", "Vladislav",
            "Gavriil", "Gleb", "Georgii",
            "David", "Daniil", "Denis",
            "Evgenii", "Egor", "Efim",
            "Zahar", "Zinovy",
            "Ivan", "Igor", "Ilia",
            "Kirill", "Klim", "Konstantin",
            "Lev", "Leonid",
            "Maksim", "Marat", "Mark",
            "Nazar", "Nikita", "Nikolay",
            "Oleg",
            "Pavel", "Petr", "Prohor",
            "Renat", "Rodion", "Roman",
            "Semion", "Sergey", "Stepan",
            "Taras", "Timur", "Tikhon",
            "Fedor", "Feliks", "Filipp",
            "Eduard",
            "Iurii",
            "Iakov", "Ian", "Jaroslav"
    };

    private static String lastNames[] = {
            "Alexeev", "Alexandrov", "Antonov",
            "Basov", "Bobrov", "Borisov",
            "Vavilov", "Vinokurov", "Voronin",
            "Gavrilov", "Galkin", "Glebov",
            "Danilov", "Denisov", "Drozdov",
            "Egorov", "Ermilov", "Erokhin",
            "Zharov", "Zhdanov", "Zhilin",
            "Zavialov", "Zaitsev", "Zorin",
            "Ivanov", "Ignatov", "Isaev",
            "Kazakov", "Kalashnikov", "Kalinin",
            "Lavrov", "Lapshin", "Lebedev",
            "Makarov", "Makeev", "Mukhin",
            "Nazarov", "Nesterov", "Nikolaev",
            "Ovsiannikov", "Okulov", "Ostrovskiy",
            "Pavlov", "Popov", "Proshin",
            "Rakov", "Rogov", "Rybakov",
            "Saveliev", "Samsonov", "Soloviev",
            "Tarasov", "Tikhonov", "Troshin",
            "Ulianov", "Uvarov", "Ustinov",
            "Fadeev", "Fedotov", "Fomin",
            "Kharitonov", "Khomiakov", "Khudiakov",
            "Tsarev", "Tsvetkov", "Tsypkin",
            "Cherkasov", "Chernov", "Chizhov",
            "Shapovalov", "Shestakov", "Shubin",
            "Shcheglov", "Shcherbakov", "Shchukin",
            "Iakovlev", "Iashin", "Iankovskiy"
    };

    private static final int PHONE_NUMBER_LENGTH = 11;

    private static final double MAX_AREA = 150.0d;

    private Random random = new Random();

    public String getRandomFirstName() {
        return firstNames[random.nextInt(firstNames.length)];
    }

    public String getRandomLastName() {
        return lastNames[random.nextInt(lastNames.length)];
    }

    public String getRandomPhoneNumber() {
        StringBuilder randomPhoneNumber = new StringBuilder("8");
        for (int i = 0; i < PHONE_NUMBER_LENGTH - 1; ++i) {
            randomPhoneNumber.append(random.nextInt(10));
        }
        return new String(randomPhoneNumber);
    }

    public Double getRandomArea() {
        return random.nextDouble() % MAX_AREA;
    }
}
