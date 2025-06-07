// package com.exemple.pecas;

// import org.hibernate.dialect.Dialect;
// import org.hibernate.dialect.function.StandardSQLFunction;
// import org.hibernate.type.StringType;

// public class SQLiteDialect extends Dialect {
//     public SQLiteDialect() {
//         super();
//         registerFunction("lower", new StandardSQLFunction("lower", StringType.INSTANCE));
//         // Adicione outros registradores conforme necessidade
//     }

//     @Override
//     public boolean supportsIdentityColumns() {
//         return true;
//     }

//     @Override
//     public boolean hasDataTypeInIdentityColumn() {
//         return false;
//     }

//     @Override
//     public String getIdentityColumnString() {
//         return "integer";
//     }

//     @Override
//     public String getIdentitySelectString() {
//         return "select last_insert_rowid()";
//     }

//     @Override
//     public boolean supportsLimit() {
//         return true;
//     }

//     @Override
//     public String getLimitString(String query, boolean hasOffset) {
//         return query + (hasOffset ? " limit ? offset ?" : " limit ?");
//     }

//     // etc: continue adaptando os métodos conforme necessário
// }
