package org.example.entity.catalog;

import java.util.UUID;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public final class CatalogValueId {

    @Column(updatable = false, nullable = false, columnDefinition = "CHAR(36)") // no explicit name for direct id usage as foreign key, named after property
    @Basic
    private UUID uuid;

    public CatalogValueId(final UUID uuid) {
        this.uuid = uuid;
    }

    protected CatalogValueId() { // for hibernate
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CatalogValueId) {
            return uuid.equals(((CatalogValueId) obj).getUuid());
        }
        return false;
    }

    protected void setUuid(UUID uuid) { // for hibernate
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return "CatalogValueId(" + uuid + ")";
    }
}
