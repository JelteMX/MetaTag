// This file was generated by Mendix Business Modeler.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package system.proxies;

/**
 * 
 */
public class Error
{
	private final com.mendix.systemwideinterfaces.core.IMendixObject errorMendixObject;

	private final com.mendix.systemwideinterfaces.core.IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "System.Error";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		ErrorType("ErrorType"),
		Message("Message"),
		Stacktrace("Stacktrace");

		private java.lang.String metaName;

		MemberNames(java.lang.String s)
		{
			metaName = s;
		}

		@Override
		public java.lang.String toString()
		{
			return metaName;
		}
	}

	public Error(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, "System.Error"));
	}

	protected Error(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject errorMendixObject)
	{
		if (errorMendixObject == null)
			throw new java.lang.IllegalArgumentException("The given object cannot be null.");
		if (!com.mendix.core.Core.isSubClassOf("System.Error", errorMendixObject.getType()))
			throw new java.lang.IllegalArgumentException("The given object is not a System.Error");

		this.errorMendixObject = errorMendixObject;
		this.context = context;
	}

	/**
	 * @deprecated Use 'Error.load(IContext, IMendixIdentifier)' instead.
	 */
	@Deprecated
	public static system.proxies.Error initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		return system.proxies.Error.load(context, mendixIdentifier);
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.getSudoContext() can be used to obtain sudo access).
	 */
	public static system.proxies.Error initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		if (com.mendix.core.Core.isSubClassOf("System.SoapFault", mendixObject.getType()))
			return system.proxies.SoapFault.initialize(context, mendixObject);

		return new system.proxies.Error(context, mendixObject);
	}

	public static system.proxies.Error load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return system.proxies.Error.initialize(context, mendixObject);
	}

	/**
	 * Commit the changes made on this proxy object.
	 */
	public final void commit() throws com.mendix.core.CoreException
	{
		com.mendix.core.Core.commit(context, getMendixObject());
	}

	/**
	 * Commit the changes made on this proxy object using the specified context.
	 */
	public final void commit(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		com.mendix.core.Core.commit(context, getMendixObject());
	}

	/**
	 * Delete the object.
	 */
	public final void delete()
	{
		com.mendix.core.Core.delete(context, getMendixObject());
	}

	/**
	 * Delete the object using the specified context.
	 */
	public final void delete(com.mendix.systemwideinterfaces.core.IContext context)
	{
		com.mendix.core.Core.delete(context, getMendixObject());
	}
	/**
	 * @return value of ErrorType
	 */
	public final String getErrorType()
	{
		return getErrorType(getContext());
	}

	/**
	 * @param context
	 * @return value of ErrorType
	 */
	public final String getErrorType(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (String) getMendixObject().getValue(context, MemberNames.ErrorType.toString());
	}

	/**
	 * Set value of ErrorType
	 * @param errortype
	 */
	public final void setErrorType(String errortype)
	{
		setErrorType(getContext(), errortype);
	}

	/**
	 * Set value of ErrorType
	 * @param context
	 * @param errortype
	 */
	public final void setErrorType(com.mendix.systemwideinterfaces.core.IContext context, String errortype)
	{
		getMendixObject().setValue(context, MemberNames.ErrorType.toString(), errortype);
	}

	/**
	 * @return value of Message
	 */
	public final String getMessage()
	{
		return getMessage(getContext());
	}

	/**
	 * @param context
	 * @return value of Message
	 */
	public final String getMessage(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (String) getMendixObject().getValue(context, MemberNames.Message.toString());
	}

	/**
	 * Set value of Message
	 * @param message
	 */
	public final void setMessage(String message)
	{
		setMessage(getContext(), message);
	}

	/**
	 * Set value of Message
	 * @param context
	 * @param message
	 */
	public final void setMessage(com.mendix.systemwideinterfaces.core.IContext context, String message)
	{
		getMendixObject().setValue(context, MemberNames.Message.toString(), message);
	}

	/**
	 * @return value of Stacktrace
	 */
	public final String getStacktrace()
	{
		return getStacktrace(getContext());
	}

	/**
	 * @param context
	 * @return value of Stacktrace
	 */
	public final String getStacktrace(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (String) getMendixObject().getValue(context, MemberNames.Stacktrace.toString());
	}

	/**
	 * Set value of Stacktrace
	 * @param stacktrace
	 */
	public final void setStacktrace(String stacktrace)
	{
		setStacktrace(getContext(), stacktrace);
	}

	/**
	 * Set value of Stacktrace
	 * @param context
	 * @param stacktrace
	 */
	public final void setStacktrace(com.mendix.systemwideinterfaces.core.IContext context, String stacktrace)
	{
		getMendixObject().setValue(context, MemberNames.Stacktrace.toString(), stacktrace);
	}

	/**
	 * @return the IMendixObject instance of this proxy for use in the Core interface.
	 */
	public final com.mendix.systemwideinterfaces.core.IMendixObject getMendixObject()
	{
		return errorMendixObject;
	}

	/**
	 * @return the IContext instance of this proxy, or null if no IContext instance was specified at initialization.
	 */
	public final com.mendix.systemwideinterfaces.core.IContext getContext()
	{
		return context;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == this)
			return true;

		if (obj != null && getClass().equals(obj.getClass()))
		{
			final system.proxies.Error that = (system.proxies.Error) obj;
			return getMendixObject().equals(that.getMendixObject());
		}
		return false;
	}

	@Override
	public int hashCode()
	{
		return getMendixObject().hashCode();
	}

	/**
	 * @return String name of this class
	 */
	public static java.lang.String getType()
	{
		return "System.Error";
	}

	/**
	 * @return String GUID from this object, format: ID_0000000000
	 * @deprecated Use getMendixObject().getId().toLong() to get a unique identifier for this object.
	 */
	@Deprecated
	public java.lang.String getGUID()
	{
		return "ID_" + getMendixObject().getId().toLong();
	}
}
