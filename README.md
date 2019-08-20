# Generics
## Why?
- Compile-time type safety rather than runtime errors
- Removes clutter of casting

## How are the implemented?
- No additional classes are generated (like templates)
- Generic type parameters are `erased` and replaced with `Object` or their bounds
- This means no runtime overhead
- Applies some restrictions because non-reified:
    - Methods with same erasure can't be overloaded
    - No class literals for generic types and no `instanceof`
    - No generic arrays - covariants vs invariants

## When to use Raw, Object, Wildcard
- Raw types exist only for backward compatibility and should never be used
- `List<Object>` is restrictive
- `List<?>` offers more flexibility especially with bounds - gives covariance and contravariance
- Use wildcards if the method does not depend on the type parameters rather than `Object`
    - GET-PUT / PECS
    - Never for return types
    
## HTC for parameterised keys
- Useful for type safety with variable amount of parameters
    - Database rows
    - ServiceRegistry
- Heterogeneous as all keys are different, typesafe guarantee from methods