db.createUser(
        {
            user: "codex-user",
            pwd: "C0d3X",
            roles: [
                {
                    role: "readWrite",
                    db: "codex"
                }
            ]
        }
);