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

`JpaRepository` was selected because it provides the complete Spring Data JPA
API needed by the application. It includes CRUD operations, list-based
collection results, sorting, pagination, and JPA-specific operations such as
`flush()` and `saveAndFlush()`.

The first generic type identifies the entity managed by the repository. The
second identifies the entity's primary-key type. All AutoLoc entities use a
`Long` primary key, so the repository declaration follows this format:

```java
public interface IContratRepository
        extends JpaRepository<Contrat, Long> {
}
```

## SonarQube for IDE cleanup

During the SonarQube for IDE review, unused imports were identified in the
source files. The imports that were not needed were removed. This was the
only SonarQube for IDE cleanup performed for this atelier.

| Anomaly | Correction |
|---|---|
| Unused imports | Removed imports that were not used by the source files |

