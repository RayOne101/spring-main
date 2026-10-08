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

