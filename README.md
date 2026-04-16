# DynaLab

DynaLab to aplikacja backendowa oparta o Spring Boot, służąca do tworzenia modeli dynamicznych, konfigurowania symulacji oraz uruchamiania obliczeń dla zadanych warunków początkowych.

## Opis projektu

DynaLab umożliwia użytkownikowi definiowanie układów równań różniczkowych w postaci dwóch funkcji:
- dx/dt = f(x, y)
- dy/dt = g(x, y)

Na podstawie takich modeli użytkownik może tworzyć symulacje, dodawać wiele warunków początkowych, uruchamiać obliczenia i pobierać zapisane wyniki.

Projekt udostępnia REST API oraz wykorzystuje JWT do autoryzacji użytkowników.

## Features

- rejestracja i logowanie użytkowników
- uwierzytelnianie i autoryzacja przy użyciu JWT
- tworzenie modeli dynamicznych
- edycja modeli
- tworzenie symulacji dla wybranego modelu
- dodawanie wielu warunków początkowych do jednej symulacji
- uruchamianie symulacji numerycznych
- zapisywanie wyników symulacji w bazie danych
- pobieranie wyników przez REST API
- obsługa relacji między modelami, symulacjami, punktami początkowymi i wynikami

## Co robi aplikacja

Aplikacja pozwala użytkownikowi:
- zalogować się do systemu
- utworzyć model matematyczny opisany równaniami xExpression i yExpression
- utworzyć symulację dla wybranego modelu
- dodać zestaw warunków początkowych
- uruchomić obliczenia dla wszystkich punktów startowych przypisanych do symulacji
- pobrać wyniki i wykorzystać je dalej, np. do wizualizacji lub analizy

## Główne moduły

- authentication – obsługa logowania, rejestracji i tokenów JWT
- models – zarządzanie modelami dynamicznymi
- simulations – zarządzanie symulacjami
- initial conditions – definiowanie punktów początkowych
- results – zapis i odczyt wyników symulacji
- security – konfiguracja zabezpieczeń i filtrowanie requestów

## Technologie

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- JWT
- Hibernate
- Maven
- Relacyjna baza danych

## Architektura

Projekt jest zorganizowany warstwowo:
- controller – przyjmuje requesty HTTP i zwraca odpowiedzi
- service – zawiera logikę biznesową
- repository – komunikuje się z bazą danych
- entity – reprezentuje obiekty domenowe
- security – obsługuje autoryzację i uwierzytelnianie

## Bezpieczeństwo

Aplikacja wykorzystuje JWT oraz podejście stateless authentication.
Chronione endpointy wymagają nagłówka:

Authorization: Bearer token

## Cel projektu

Celem projektu jest stworzenie backendu do zarządzania modelami dynamicznymi i wykonywania symulacji numerycznych w uporządkowany, bezpieczny i rozszerzalny sposób.

## Podsumowanie

DynaLab to backend do modelowania i symulowania układów dynamicznych. Umożliwia zarządzanie modelami, konfiguracją symulacji, warunkami początkowymi i wynikami, a także zapewnia bezpieczny dostęp do API przy użyciu JWT.