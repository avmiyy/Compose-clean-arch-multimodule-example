# Compose clean arch multimodule example 

- Compose
- Hilt
- Room

## Modules schema:

```mermaid 
graph TD
:domain --> :data
:domain --> :presentation 
:data --> :app 
:presentation --> :app 
```
