/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2008, Red Hat Middleware LLC or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Middleware LLC.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 *
 */
package org.hibernate.context;
import java.io.Serializable;
import org.hibernate.HibernateException;

/**
 * Defines the contract for implementations which know how to scope the notion
 * of a {@link org.hibernate.SessionFactory#getCurrentSession() current session}.
 * <p/>
 * Implementations should adhere to the following:
 * <ul>
 * <li>contain a constructor accepting a single argument of type
 * {@link org.hibernate.engine.SessionFactoryImplementor}
 * <li>should be thread safe
 * <li>should be fully serializable
 * </ul>
 * <p/>
 * Implementors should be aware that they are also fully responsible for
 * cleanup of any generated current-sessions.
 * <p/>
 * Note that there will be exactly one instance of the configured
 * CurrentSessionContext implementation per {@link org.hibernate.SessionFactory}.
 *
 * @author Steve Ebersole
 */
public interface CurrentSessionContext extends Serializable {
	/**
	 * Retrieve the current session according to the scoping defined
	 * by this implementation.
	 *
	 * @return The current session.
	 * @throws HibernateException Typically indicates an issue
	 * locating or creating the current session.
	 */
	public org.hibernate.classic.Session currentSession() throws HibernateException;
}
