/*
 * Copyright (C) 2020 Grakn Labs
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package graql.lang.pattern.variable;

import graql.lang.pattern.property.Property;
import graql.lang.pattern.property.ThingProperty;
import graql.lang.pattern.property.TypeProperty;
import graql.lang.pattern.variable.builder.ThingVariableBuilder;
import graql.lang.pattern.variable.builder.TypeVariableBuilder;

import java.util.Set;

import static grakn.common.collection.Collections.set;

public class UnboundVariable extends Variable<UnboundVariable> implements TypeVariableBuilder,
                                                                          ThingVariableBuilder<ThingVariable.Thing>,
                                                                          ThingVariableBuilder.Thing,
                                                                          ThingVariableBuilder.Relation,
                                                                          ThingVariableBuilder.Attribute {

    private UnboundVariable(Identity identity) {
        super(identity);
    }

    public static UnboundVariable of(Identity identity) {
        return new UnboundVariable(identity);
    }

    public static UnboundVariable named(String name) {
        return of(Identity.named(name));
    }

    public static UnboundVariable anonymous() {
        return of(Identity.anonymous(true));
    }

    public static UnboundVariable hidden() {
        return of(Identity.anonymous(false));
    }

    @Override
    public TypeVariable asType() {
        return new TypeVariable(identity, null);
    }

    @Override
    public ThingVariable<?> asThing() {
        return new ThingVariable.Thing(identity, null);
    }

    @Override
    public UnboundVariable withoutProperties() {
        return this;
    }

    @Override
    public Set<Property> properties() {
        return set();
    }

    @Override
    public TypeVariable asTypeWith(TypeProperty.Singular property) {
        if (!isVisible() && property instanceof TypeProperty.Label) {
            return new TypeVariable(Identity.label(((TypeProperty.Label) property).label()), property);
        } else {
            return new TypeVariable(identity, property);
        }
    }

    @Override
    public TypeVariable asTypeWith(TypeProperty.Repeatable property) {
        return new TypeVariable(identity, property);
    }

    @Override
    public ThingVariable.Thing asSameThingWith(ThingProperty.Singular property) {
        return new ThingVariable.Thing(identity, property);
    }

    @Override
    public ThingVariable.Thing asSameThingWith(ThingProperty.Repeatable property) {
        return new ThingVariable.Thing(identity, property);
    }

    @Override
    public ThingVariable.Thing asThingWith(ThingProperty.Singular property) {
        return new ThingVariable.Thing(identity, property);
    }

    @Override
    public ThingVariable.Attribute asAttributeWith(ThingProperty.Value<?> property) {
        return new ThingVariable.Attribute(identity, property);
    }

    @Override
    public ThingVariable.Relation asRelationWith(ThingProperty.Relation.RolePlayer rolePlayer) {
        return asRelationWith(new ThingProperty.Relation(rolePlayer));
    }

    public ThingVariable.Relation asRelationWith(ThingProperty.Relation property) {
        return new ThingVariable.Relation(identity, property);
    }

    @Override
    public String toString() {
        return identity.syntax();
    }
}
