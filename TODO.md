# TODO
- data class Task
  - ID: String (UUID)
  - Description: String
  - CreatedDateTime
  - ScheduledDateTime
  - Status: Enum {"CREATED", "RUNNING", "DONE"}
  - StatusChangeDateTime
- Lambdas
  - List
  - Create
  - Delete (id)
  - Get (id)
  - Update (id)
- API GW
  - List (GET /)
  - Create (POST /)
  - Delete (DELETE /{id})
  - Update (PUT /{id})
- DDB Table
  - SAM Policy Template
- Figure out how to sync lambda jar version with template.yml automatically
    - when I change the lambda package version, template.yml should pick it up automatically