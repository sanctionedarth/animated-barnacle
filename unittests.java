interface IOrderRepository
{
    Order GetOrderByID(Guid id);
}

class OrderRepository : IOrderRepository
{
    private readonly ISqlExecutor sqlExecutor;
    public OrderRepository(ISqlExecutor sqlExecutor)
    {
        this.sqlExecutor = sqlExecutor;
    }

    public Order GetOrderByID(Guid id)
    {
        var sql = "SELECT blah, blah FROM Order WHERE OrderId = @p0";
        var dataset = this.sqlExecutor.Execute(sql, p0 = id);
        var result = this.orderFromDataset(dataset);
        return result;
    }
}
