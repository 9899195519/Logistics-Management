Start Cassandra

Go into the Cassandra folder:

cd ~/cassandra5
bin/cassandra -f

-------------------
Host: 172.30.37.96
User : cassandra
Password: cassandra
--------------------
to create key space
CREATE KEYSPACE IF NOT EXISTS logistics_db WITH replication = {
  'class': 'SimpleStrategy',
  'replication_factor': 1
};