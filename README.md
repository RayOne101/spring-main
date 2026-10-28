# Repository notes

## Interface choice

The nine AutoLoc repositories extend `JpaRepository<Entity, Long>`:

- `IAgenceRepository`
- `IEmployeRepository`
- `IVehiculeRepository`
- `IEquipementRepository`
- `IClientRepository`
- `IReservationRepository`
- `IContratRepository`
- `IPaiementRepository`
- `IMaintenanceRepository`

## SonarQube

| Anomaly | Correction |
|---|---|
| Unused imports | Removed imports that were not used by the source files |

---

# Atelier 5 — REST API testing with Postman


Swagger UI: `http://localhost:8080/api/swagger-ui.html`

## Swagger UI

![Swagger UI - Véhicules](spring-main/autoloc-api/docs/screenshots/swagger-ui.png)

## Agence

### Create — `POST /agences` → 201 Created

![POST /agences - 201 Created](spring-main/autoloc-api/docs/screenshots/agence-post-201.png)

### List — `GET /agences` → 200 OK

![GET /agences - 200 OK](spring-main/autoloc-api/docs/screenshots/agence-get-all-200.png)

### Read — `GET /agences/2` → 200 OK

![GET /agences/2 - 200 OK](spring-main/autoloc-api/docs/screenshots/agence-get-by-id-200.png)

### Update — `PUT /agences/3` → 200 OK

![PUT /agences/3 - 200 OK](spring-main/autoloc-api/docs/screenshots/agence-put-200.png)

### Delete — `DELETE /agences/2` → 204 No Content

![DELETE /agences/2 - 204 No Content](spring-main/autoloc-api/docs/screenshots/agence-delete-204.png)

### Not found — `GET /agences/9999` → 404 Not Found

![GET /agences/9999 - 404 Not Found](spring-main/autoloc-api/docs/screenshots/agence-get-404.png)

### Invalid body — `POST /agences` with empty `nom` → 400 Bad Request

![POST /agences without nom - 400 Bad Request](spring-main/autoloc-api/docs/screenshots/agence-post-400.png)

## Client

### Create — `POST /clients` → 201 Created

![POST /clients - 201 Created](spring-main/autoloc-api/docs/screenshots/client-post-201.png)

### List — `GET /clients` → 200 OK

![GET /clients - 200 OK](spring-main/autoloc-api/docs/screenshots/client-get-all-200.png)

### Read — `GET /clients/3` → 200 OK

![GET /clients/3 - 200 OK](spring-main/autoloc-api/docs/screenshots/client-get-by-id-200.png)

### Update — `PUT /clients/3` → 200 OK

![PUT /clients/3 - 200 OK](spring-main/autoloc-api/docs/screenshots/client-put-200.png)

### Delete — `DELETE /clients/2` → 204 No Content

![DELETE /clients/2 - 204 No Content](spring-main/autoloc-api/docs/screenshots/client-delete-204.png)

### Not found — `GET /clients/9999` → 404 Not Found

![GET /clients/9999 - 404 Not Found](spring-main/autoloc-api/docs/screenshots/client-get-404.png)

### Invalid body — `POST /clients` with empty `email` → 400 Bad Request

![POST /clients without email - 400 Bad Request](spring-main/autoloc-api/docs/screenshots/client-post-400.png)

## Véhicule

### Create — `POST /vehicules` → 201 Created

![POST /vehicules - 201 Created](spring-main/autoloc-api/docs/screenshots/vehicule-post-201.png)

### List — `GET /vehicules` → 200 OK

![GET /vehicules - 200 OK](spring-main/autoloc-api/docs/screenshots/vehicule-get-all-200.png)

### Read — `GET /vehicules/3` → 200 OK

![GET /vehicules/3 - 200 OK](spring-main/autoloc-api/docs/screenshots/vehicule-get-by-id-200.png)

### Update — `PUT /vehicules/3` → 200 OK

![PUT /vehicules/3 - 200 OK](spring-main/autoloc-api/docs/screenshots/vehicule-put-200.png)

### Delete — `DELETE /vehicules/3` → 204 No Content

![DELETE /vehicules/3 - 204 No Content](spring-main/autoloc-api/docs/screenshots/vehicule-delete-204.png)

### Not found — `GET /vehicules/9999` → 404 Not Found

![GET /vehicules/9999 - 404 Not Found](spring-main/autoloc-api/docs/screenshots/vehicule-get-404.png)

### Invalid body — `POST /vehicules` with negative `tarifJournalier` → 400 Bad Request

![POST /vehicules with negative tarif - 400 Bad Request](spring-main/autoloc-api/docs/screenshots/vehicule-post-400.png)


