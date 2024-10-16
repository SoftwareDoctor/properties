# Applicativo per gestione immobili

## Descrizione

Questo applicativo è progettato per gestire un database in un contesto immobiliare utilizzando l'API SheetDB. Permette di aggiornare e gestire informazioni relative a immobili.

## Tecnologie Utilizzate

- **Java 17**
- **Spring Boot**
- **WebClient**

## Dettagli sull'Implementazione del WebClient

Nel progetto, è stato configurato un `WebClient` per comunicare con l'API SheetDB. La classe di configurazione `WebClientConfig` viene definito il bean `WebClient`.
Nella configurazione, il WebClient è configurato con l'URL di base di SheetDB e un header di autorizzazione utilizzando l'autenticazione Bearer.
WebClient è un componente di Spring che fornisce un modo non bloccante per effettuare chiamate HTTP. È utilizzato per interagire con l'API SheetDB, consentendo di inviare richieste e gestire le risposte in modo reattivo e asincrono. 

## A cosa serve SheetDB
SheetDB è un'API che consente di trasformare un foglio di calcolo Google in un database JSON. Offre una soluzione semplice per gestire dati strutturati senza la necessità di utilizzare un sistema di gestione del database complesso. Attraverso SheetDB, è possibile effettuare operazioni CRUD (Create, Read, Update, Delete) sui dati memorizzati nel foglio di calcolo, rendendolo ideale per applicazioni che richiedono una gestione dei dati leggera e flessibile.

# Registrazione e Token di Accesso
Per utilizzare l'API SheetDB, è necessario:
    - Registrazione su SheetDB
    - Creazione di un file con la struttura desiderata
    - Ottenere un token da SheetDB 

## Autore
Andrea Italiano