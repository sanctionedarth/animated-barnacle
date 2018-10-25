/// <summary>
/// Repository factory for integration tests.
/// </summary>
internal class RepositoryFactory
{
    /// <summary>
    /// Gets an instance of the repository.
    /// </summary>
    /// <param name="instance">The instance.</param>
    /// <returns>
    /// An instance of the repository under test.
    /// </returns>
    internal static object Instance(string instance)
    {
        string targetAssembly = ConfigurationManager.AppSettings["targetAssembly"];
        return Activator.CreateInstance(targetAssembly, targetAssembly + "." + instance).Unwrap();
    }
}
